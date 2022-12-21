package hello.upload.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Multipart
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultipartTest {
	private String itemName;
	private MultipartFile file;
}
