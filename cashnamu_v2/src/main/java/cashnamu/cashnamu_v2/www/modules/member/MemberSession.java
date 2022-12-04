package cashnamu.cashnamu_v2.www.modules.member;

import javax.servlet.http.HttpSession;

import cashnamu.cashnamu_v2.www.modules.member.dto.MemberDTO;

public class MemberSession {

	private static String SessionId = "__cashnamu_user";
	
	public static void CreateUserSession(HttpSession session,MemberDTO user) {
		session.setAttribute(SessionId, user);
	}
	
	public static boolean isAuthorites(HttpSession session) {
		return session.getAttribute(SessionId) != null;
	}
	
	public static void ClearUserSession(HttpSession session) {
		session.removeAttribute(SessionId);
	}

	public static MemberDTO getUserSession(HttpSession session) {
		return (MemberDTO) session.getAttribute(SessionId);
	}
}
