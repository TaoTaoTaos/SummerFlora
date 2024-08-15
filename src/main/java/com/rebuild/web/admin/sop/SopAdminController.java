
package com.rebuild.web.admin.sop;

import com.rebuild.core.support.i18n.Language;
import com.rebuild.utils.RbAssert;
import com.rebuild.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author devezhao
 * @since 2024/4/8
 */
@Controller
public class SopAdminController extends BaseController {

    @GetMapping("/admin/robot/sops")
    public ModelAndView pageList() {
        RbAssert.isCommercial(
                Language.L(" 不支持业务进度功能 [()]("));
        return createModelAndView("/admin/robot/sop-list");
    }
}
