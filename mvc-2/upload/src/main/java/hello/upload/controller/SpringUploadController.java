package hello.upload.controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import hello.upload.domain.MultipartTest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * SpringUploadController
 */
@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {

	@Value("${file.dir}")
	private String fileDir;

	@GetMapping("/upload")
	public String newFile() {
		return "upload-form";
	}

	@PostMapping("/upload")
	public String saveFile(@ModelAttribute MultipartTest item,
						   HttpServletRequest request) throws IOException {
		log.info("request={}", request);
		log.info("itemName={}", item.getItemName());
		log.info("multipartFile={}", item.getFile());

		if(!item.getFile().isEmpty()) {
			String fullPath = fileDir + item.getFile().getOriginalFilename();
			log.info("파일 저장 fullPath={}", fullPath);
			item.getFile().transferTo(new File(fullPath));
		}

		return "upload-form";

	}

}
