package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.utils.AliyunOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> uploadFile(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        // 分割文件名和扩展名
        String[] splitName = originalFilename.split("\\.(?=[^\\.]+$)");
        String nameWithoutExt = splitName[0];
        String extension = splitName.length > 1 ? "." + splitName[1] : "";

        // 生成随机字符串（UUID去横杠）
        String randomStr = UUID.randomUUID().toString().replace("-", "");

        // 构建新文件名
        String newFilename = nameWithoutExt + "_" + randomStr + extension;

//        file.transferTo(new File("E:\\Documents\\Project\\Android Health Check-In System\\TestFileStorage\\" + newFilename));
        String ossUrl = AliyunOssUtil.ossUploadFile(newFilename, file.getInputStream());
        return Result.success(ossUrl);
    }

}
