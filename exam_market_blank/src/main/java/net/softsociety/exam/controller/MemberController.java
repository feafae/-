package net.softsociety.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.CreateMemberForm;
import net.softsociety.exam.domain.LoginForm;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.domain.RoleType;
import net.softsociety.exam.security.UserInfo;
import net.softsociety.exam.service.MemberService;

/**
 * �쉶�썝 �젙蹂� 愿��젴 肄섑듃濡ㅻ윭
 */

@Slf4j
@RequestMapping("member")
@RequiredArgsConstructor
@Controller
public class MemberController {
	private final MemberService memberService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(path = "/join")
    public String joinForm(Model model) {
		model.addAttribute("createMemberForm", new CreateMemberForm());
        return "member/joinForm";
    }
	@PostMapping(value = "/join")
    public String join(@Validated @ModelAttribute("createMemberForm") CreateMemberForm createMemberForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/joinForm";
        }
        Member member = createMemberForm.toMember();
        member.setMemberpw(bCryptPasswordEncoder.encode(member.getMemberpw()));
        member.setRolename(RoleType.ROLE_USER);
        memberService.saveMember(member);
        return "redirect:/";
    }
	@GetMapping(value = "/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "member/loginForm";
    }
	@GetMapping(value = "/login-success")
    public String login_success(@AuthenticationPrincipal UserInfo userInfo) {
        return "redirect:/board/list";
    }
	@GetMapping(value = "/login-fail")
    public String login_fail() {
        return "redirect:/member/login";
    }
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

  @ResponseBody
  @GetMapping(value = "/checkIdDuplicate")
  public ResponseEntity checiIdDuplicateV2(@RequestParam("id") String id) {
      log.info("id : {}", id);
      Member findMember = memberService.findMember(id);
      if (findMember == null) {
          return new ResponseEntity(null, HttpStatus.OK);
      }
      return new ResponseEntity(findMember.getMemberid(), HttpStatus.OK);
  }
	
	
	
	
	
	
	
	
	
	
}
