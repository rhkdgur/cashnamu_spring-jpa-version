package cashnamu.cashnamu_v2.www;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www
* @fileName        : BaseResult.java
* @author        : rhkdg
* @param <T>
* @description : 목록 전송 처리 시스템 (api 전용)
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.11.30	고광혁			최초생성
 */
@Data
@AllArgsConstructor
public class BaseResult<T> {
	private T data;
}
