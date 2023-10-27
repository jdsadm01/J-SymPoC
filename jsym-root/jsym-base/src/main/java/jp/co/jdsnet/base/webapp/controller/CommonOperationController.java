package jp.co.jdsnet.base.webapp.controller;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.http.HttpSession;

public abstract class CommonOperationController {

    @Autowired
    private HttpSession httpSession;

    @Value("${property.session.userInfoKey}")
    private String userInfoKey;

    @SuppressWarnings("unchecked")
	protected ConcurrentHashMap<String,String> getUserMap() {
		return (ConcurrentHashMap<String,String>)httpSession.getAttribute(userInfoKey);
	}
}
