package org.dcsc.admin.view;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * Controller that returns all views (HTML templates)
 */
@Controller("adminViewController")
public class ViewController {
    private static final Set<String> COMMON_VIEWS = Sets.newHashSet("sidebar", "header");
    private static final String COMMON_VIEW_FORMAT = "admin/view/common/%s::altair";
    private static final String STANDARD_VIEW_FORMAT = "admin/view/%s::altair";
    private static final String EDIT_VIEW_FORMAT = "admin/view/edit/%s::altair";

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getLogin(Model model) {
        model.addAttribute("isDevMode", environment.acceptsProfiles("dev"));
        return ViewNames.LOGIN;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public void redirectToApplicationShell(HttpServletResponse response) throws Exception {
        response.sendRedirect("/admin/");
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getApplicationShell() {
        return ViewNames.ALTAIR_APPLICATION_SHELL;
    }

    @RequestMapping(value = "/admin/view/{viewId}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getView(@PathVariable("viewId") String viewId) {
        String viewNameFormat = STANDARD_VIEW_FORMAT;

        if (COMMON_VIEWS.contains(viewId)) {
            viewNameFormat = COMMON_VIEW_FORMAT;
        }

        return String.format(viewNameFormat, viewId);
    }

    @RequestMapping(value = "/admin/view/{viewId}/edit", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String getEdit(@PathVariable("viewId") String viewId) {
        return String.format(EDIT_VIEW_FORMAT, viewId);
    }
}
