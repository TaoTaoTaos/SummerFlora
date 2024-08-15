
package com.rebuild.web.admin.extform;

import com.rebuild.core.support.i18n.Language;
import com.rebuild.utils.RbAssert;
import com.rebuild.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author devezhao
 * @since 2020/12/8
 */
@Controller
public class ExtformAdminController extends BaseController {

    @GetMapping("/admin/extforms")
    public ModelAndView pageList() {
        RbAssert.isCommercial(
                Language.L(" 不支持外部表单功能 [()]("));
        return createModelAndView("/admin/extform/extform-list");
    }
}
