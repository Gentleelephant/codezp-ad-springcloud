package club.constant;

import lombok.Getter;

/**
 * @Author:Zpg
 * @Date:2020/8/1 21:29
 * @Version:1.0
 * @Description: 用户状态
 */
@Getter
public enum CommonStatus {

    /**
     * 有效状态
     */
    VALID(1,"有效状态"),
    /**
     * 无效状态
     */
    INVALID(0,"无效状态");


    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
