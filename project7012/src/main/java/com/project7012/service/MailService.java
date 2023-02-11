package com.project7012.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender emailsender; // Bean 등록해둔 MailConfig 를 emailsender 라는 이름으로 autowired

	// 메일 내용 작성
	public MimeMessage createMessage(String to, String name, String manitto) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = emailsender.createMimeMessage();

		message.addRecipients(RecipientType.TO, to);// 보내는 대상
		message.setSubject("쉿, 비밀이야!");// 제목

		String msgg = "";
		msgg += "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/galmuri@latest/dist/galmuri.css\">";
		msgg += "<div align='center' style='margin:100px;' font-family='Galmuri11'>";
		msgg += "<h1> Letters to 7012 &#128330;</h1>";
		msgg += "<br>";
		msgg += "<p> 안녕 "+ name + ", 2022년을 지나 2023년도 함께해 줘서 고마워<p>";
		msgg += "<p> 올 한 해에도 좋은 일만 가득하길 ... &#127808;<p>";
		msgg += "<br>";
		msgg += "<p>. <p>";
		msgg += "<p>. <p>";
		msgg += "<p>. <p>";
		msgg += "<br>";
		msgg += "<p> 너의 마니또를 알려줄게<p>";
		msgg += "<p> 절대 들키면 안 돼 !<p>";
		msgg += "<br>";
		msgg += "<p> 만약 들킨다면 <p>";
		msgg += "<br>";
		msgg += "<p>. <p>";
		msgg += "<p>. <p>";
		msgg += "<p>. <p>";
		msgg += "<br>";
		msgg += "<p>당신은 내년의 호스트입니다 ! <p>";
		msgg += "<p>(와아아) <p>";
		msgg += "<br>";
		msgg += "<br>";
		msgg += "<br>";
		msgg += "<div align='center' font-family:verdana';>";		
		msgg += "<p> ♡ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡̷̷̷ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡ ⋆⁺₊⋆♡ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡̷̷̷ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡ ⋆⁺₊⋆<p>";
		msgg += "<h3 style='color:pink;'>&#128140; 당신의 마니또 &#128140;</h3>";
		msgg += "<div style='font-size:130%'>"+ manitto +"</div>";
		msgg += "<br>";
		msgg += "<p>  ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡̷̷̷ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡ ⋆⁺₊⋆♡ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡̷̷̷ ⋆⁺₊⋆ ☾⋆⁺₊⋆ ♡ ⋆⁺₊⋆♡<p>";
		msgg += "</div>";
		message.setText(msgg, "utf-8", "html");// 내용, charset 타입, subtype
		// 보내는 사람의 이메일 주소, 보내는 사람 이름
		message.setFrom(new InternetAddress("02milkyway13@naver.com", "room no.7012"));// 보내는 사람

		return message;
	}

	// 메일 발송
	// sendSimpleMessage 의 매개변수로 들어온 to 는 곧 이메일 주소가 되고,
	// MimeMessage 객체 안에 내가 전송할 메일의 내용을 담는다.
	// 그리고 bean 으로 등록해둔 javaMail 객체를 사용해서 이메일 send!!
	public String sendSimpleMessage(String to, String name, String manitto) throws Exception {
		MimeMessage message = createMessage(to, name, manitto); // 메일 발송
		try {// 예외처리
			emailsender.send(message);
		} catch (MailException es) {
			es.printStackTrace();
			throw new IllegalArgumentException();
		}
		return to; // 메일로 보냈던 인증 코드를 서버로 반환
	}
}
