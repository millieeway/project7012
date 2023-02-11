package com.project7012.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project7012.service.MailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class mainController {
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/sendOk")
	public String sendOk() {
		return "sendOk";
	}
	
	@PostMapping("/sendMail")
	public String sendMain(@RequestParam("email") String[] email) throws Exception
							/*@RequestParam("name") String name)*/ {
		String[] name = {"주원", "민지", "유민", "성윤", "수빈", "이나", "은하"};
		ArrayList<String> manitto = new ArrayList<>(Arrays.asList("주원", "민지", "유민", "성윤", "수빈", "이나", "은하")); 
		Map<String, String> result = new HashMap<String, String>();
		
		if(email != null) {
			
			for(int i = 0; i < email.length; i++) {
				System.out.println("이메일 : " + email[i]);
				System.out.println("이메일 받는 사람 : " + name[i]);
				
				int no = (int)(Math.random() * manitto.size());
				if(!manitto.get(no).equals(name[i])) {
					System.out.println(name[i] + "의 마니또 : " + manitto.get(no));
					String email2 = email[i];
					String name2 = name[i];
					String manitto2 = manitto.get(no);
					mailService.sendSimpleMessage(email2, name2, manitto2);
					System.out.println("메일 전송");
					manitto.remove(no);
				}else {
					i--;
				}
			}
		}
		System.out.println("===========");
		
		return "sendOk";
	}
}
