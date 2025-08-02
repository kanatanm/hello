package jp.kobe_u.cs.daikibo.tsubuyaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;

import java.util.List;

@Controller
public class TsubuyakiController {

    @Autowired
    TsubuyakiService ts;

    // タイトル画面を表示
    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    // メイン画面を表示
    @GetMapping("/read")
    String showTsubuyakiList(Model model) {
        List<Tsubuyaki> list = ts.getAllTsubuyaki(); // つぶやき全件取得
        model.addAttribute("tsubuyakiList", list); // モデルにセット
        model.addAttribute("tsubuyakiForm", new TsubuyakiForm()); // 空のフォームをセット
        return "tsubuyaki_list"; // HTMLページ（後で作成）
    }

    // つぶやきを投稿
    @PostMapping("/read")
    String postTsubuyaki(@ModelAttribute("tsubuyakiForm") TsubuyakiForm form, Model model) {
        Tsubuyaki t = new Tsubuyaki();
        t.setName(form.getName());
        t.setComment(form.getComment());
        ts.postTsubuyaki(t); // 投稿処理（サービスに任せる）
        return "redirect:/read"; // 投稿後は再読み込み
    }
}
