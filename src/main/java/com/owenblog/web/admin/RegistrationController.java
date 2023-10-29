package com.owenblog.web.admin;

import com.owenblog.entity.User;
import com.owenblog.repository.UserRepository;
import com.owenblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/register";
    }

    @PostMapping("register")
    public String registerUser(@ModelAttribute("user") User user, RedirectAttributes attributes) {
        // 檢查用戶名是否已存在
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // 處理用戶名已存在的情況
            attributes.addFlashAttribute("message", "此帳號已有人註冊");
            return "redirect:/register"; // 重定向回註冊頁面並顯示錯誤消息
        } else {
            // 使用MD5加密密码
            String encryptedPassword = MD5Utils.code(user.getPassword());
            user.setPassword(encryptedPassword);
            // 保存新用戶
            userRepository.save(user);
            attributes.addFlashAttribute("message", "註冊成功");
            return "redirect:/admin"; // 重定向到登錄頁面
        }
    }
}
