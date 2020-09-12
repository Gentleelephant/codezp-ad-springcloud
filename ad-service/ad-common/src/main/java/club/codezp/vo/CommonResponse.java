package club.codezp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:Zpg
 * @Date:2020/8/1 18:14
 * @Version:1.0
 * @Description: 同统一返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private Integer code;

    private String message;

    private  T data;

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
