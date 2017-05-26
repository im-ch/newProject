package jeff.webController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.Sales;
import jeff.service.SalesService;

@RequestMapping(value = "sales")
@Controller
public class SalesController {

	@Autowired
	private SalesService salesService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registSales(HttpServletRequest req, Sales sales) {
		HttpSession session = req.getSession();

		String comId = (String) session.getAttribute("comId");
		sales.setCompanyId(comId);
		salesService.registSales(sales);

		return "redirect:sales/list";
	}

	@RequestMapping(value = "/remove")
	public String removeSales(Sales sales) {

		salesService.removeSales(sales.getSalesId());

		return "redirect:sales/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateSales(Sales sales, Model model) {

		sales = salesService.findBySalesId(sales.getSalesId());

		model.addAttribute("sales", sales);

		return "modifySales.jsp";
	}

	public String modifySales(Sales sales) {

		salesService.updateSales(sales);

		return "redirect:sales/list";
	}

	@RequestMapping(value = "/list")
	public String findAllSales(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession();

		String comId = (String) session.getAttribute("comId");
		
		List<Sales> list = salesService.findSalesByCompany(comId);
		
		model.addAttribute("sales", list);
		
		return "salesList.jsp";
	}
}
