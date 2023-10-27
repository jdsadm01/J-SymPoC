package jp.co.jdsnet.base.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.http.HttpSession;
import jp.co.jdsnet.common.domain.vo.UserInfoVO;

public abstract class CommonOperationController {

    @Autowired
    private HttpSession httpSession;

    @Value("${property.session.userInfoKey}")
    private String userInfoKey;

	protected UserInfoVO getUserInfo() {
		return (UserInfoVO)httpSession.getAttribute(userInfoKey);
	}
}
