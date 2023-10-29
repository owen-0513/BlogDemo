package com.owenblog.web.admin;

import com.owenblog.entity.User;
import com.owenblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("admin/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // 檢查用戶名是否已存在
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // 處理用戶名已存在的情況
        } else {
            // 保存新用戶
            userRepository.save(user);
        }
        return "redirect:admin/login"; // 重定向到登錄頁面
    }
}