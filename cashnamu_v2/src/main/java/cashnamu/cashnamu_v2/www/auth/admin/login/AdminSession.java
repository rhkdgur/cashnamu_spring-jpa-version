package cashnamu.cashnamu_v2.www.auth.admin.login;

import javax.servlet.http.HttpSession;

import cashnamu.cashnamu_v2.www.auth.admin.service.Admin;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.auth.admin.login
* @fileName        : AdminSession.java
* @author        : rhkdg
* @description :  관리자 로그인 세션
* =======================================
* DATE			AUTHOR			NOTE
* 				고광혁			최초생성
* ---------------------------------------
* 2022.11.17
 */
public class AdminSession {
	private static String SessionId = "_cashnamu_admin";
	
	public static void CreateAdminSession(HttpSession session,Admin admin) {
		session.setAttribute(SessionId, admin);
	}
	
	public static boolean isAuthorites(HttpSession session) {
		return session.getAttribute(SessionId) != null;
	}
	
	public static void ClearAdminSession(HttpSession session) {
		session.removeAttribute(SessionId);
	}
	
	public static Admin getAdminSession(HttpSession session) {
		return (Admin) session.getAttribute(SessionId);
	}
}
