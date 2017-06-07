package jeff.webController;

import java.sql.Date;

import java.util.Calendar;
import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.CompanySales;
import jeff.domain.Sales;
import jeff.service.SalesService;

@RequestMapping(value = "sales")
@Controller
public class SalesController {

	@Autowired
	private SalesService salesService;

	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
	public String registSales(HttpServletRequest req, Sales sales) {
		HttpSession session = req.getSession();

		String comId = (String) session.getAttribute("comId");
		sales.setCompanyId(comId);
		salesService.registSales(sales);

		return "redirect:list";
	}

	@RequestMapping(value = "/remove")
	public String removeSales(Sales sales) {

		salesService.removeSales(sales.getSalesId());

		return "redirect:list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateSales(Sales sales, Model model) {

		sales = salesService.findBySalesId(sales.getSalesId());

		model.addAttribute("sales", sales);

		return "modifySales";
	}

	public String modifySales(Sales sales) {

		salesService.updateSales(sales);

		return "redirect:list";
	}

	@RequestMapping(value = "/list")
	public String findAllSales(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		List<Sales> list = salesService.findSalesByCompany(comId);

		model.addAttribute("sales", list);

		return "salesList";
	}

	@RequestMapping(value = "/calendarDetailAjax", produces = "application/json")
	public @ResponseBody CompanySales calendarDetailAjax(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute Sales sales) throws Exception {
		CompanySales companySales = new CompanySales();

		HttpSession session = request.getSession();
		String comId = (String) session.getAttribute("comId");

		List<Sales> list = salesService.findSalesByCompany(comId);

		try {
			companySales.setSalesList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companySales;
	}

}