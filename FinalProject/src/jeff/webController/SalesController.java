package jeff.webController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

	@RequestMapping(value = "day")
	@ResponseBody
<<<<<<< HEAD
	public String dayChart(HttpServletRequest req){
=======
	public String ttt(HttpServletRequest req) {
>>>>>>> hyun
		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("comId") == null) {
			return "redirect:login.jsp";
		}
		String comId = (String) session.getAttribute("comId");

		JsonObject data = new JsonObject();
		JsonObject objCol1 = new JsonObject();
		JsonObject objCol2 = new JsonObject();
		JsonArray arrCols = new JsonArray();
		JsonArray arrRows = new JsonArray();
		objCol1.addProperty("type", "string");
		objCol2.addProperty("type", "number");
		arrCols.add(objCol1);
		arrCols.add(objCol2);

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<Sales> list = salesService.findSalesByCompany(comId);
		List<Sales> dayList = new ArrayList<>();
		for(int i = 0 ; i < list.size() ; i++){
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Date compare1 = list.get(i).getRegDate();
			dayList.add(list.get(i));
			if(dayList.size() == 7){
				break;
			}
		}
		int size = dayList.size();
		for(int i = size - 1 ; i >= 0 ; i--){
			JsonObject legend = new JsonObject();
			legend.addProperty("v", newFormat.format(dayList.get(i).getRegDate()));
			legend.add("f", null);
			
			JsonObject value = new JsonObject();
			value.addProperty("v", dayList.get(i).getSales());
			value.add("f", null);
			
			JsonArray cvalArr = new JsonArray();
			cvalArr.add(legend);
			cvalArr.add(value);
			
			JsonObject cvalObj = new JsonObject();
			cvalObj.add("c", cvalArr);
			
			arrRows.add(cvalObj);
		}

		data.add("cols", arrCols);
		data.add("rows", arrRows);
		String str = data.toString();
		return str;
	}
	@RequestMapping(value="week")
	@ResponseBody
	public String weekChart(HttpServletRequest req){
		HttpSession session = req.getSession();
		
		if (session == null || session.getAttribute("comId") == null) {
			return "redirect:login.jsp";
		}
		String comId = (String) session.getAttribute("comId");
		
		JsonObject data = new JsonObject();
		JsonObject objCol1 = new JsonObject();
		JsonObject objCol2 = new JsonObject();
		JsonArray arrCols = new JsonArray();
		JsonArray arrRows = new JsonArray();
		objCol1.addProperty("type", "string");
		objCol2.addProperty("type", "number");
		arrCols.add(objCol1);
		arrCols.add(objCol2);
		GregorianCalendar toda = new GregorianCalendar ( );
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<Sales> list = salesService.findSalesByCompany(comId);
		System.out.println(list.size());
		List<Sales> weekList = new ArrayList<>();
<<<<<<< HEAD
		int total = 0;
		int count = 0;
		for(int i = 0 ; i < list.size() ; i++){
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Date compare1 = list.get(i).getRegDate();
			toda.setTime(compare1);
			int dayGab = today.compareTo(compare1);
			count ++;
			total += list.get(i).getSales();
			if(count % toda.getActualMaximum(toda.DAY_OF_MONTH) == 0){
				Sales sales = list.get(i);
				sales.setSales(total);
				weekList.add(sales);
				total = 0;
			}
			if(weekList.size() == 3){
				break;
			}
		}
		int size = weekList.size();
		for(int i = size-1 ; i >= 0 ; i--){
			JsonObject legend = new JsonObject();
			legend.addProperty("v", newFormat.format(weekList.get(i).getRegDate()).substring(0, 7));
=======
		for (int i = 0; i < list.size(); i++) {
			int today = Integer.parseInt(newFormat.format(list.get(0).getRegDate()).substring(8));
			// int day =
			// if()
		}
		for (int i = 0; i < 7; i++) {
			JsonObject legend = new JsonObject();
			legend.addProperty("v", "7/" + (i + 2));
>>>>>>> hyun
			legend.add("f", null);

			JsonObject value = new JsonObject();
<<<<<<< HEAD
			value.addProperty("v", weekList.get(i).getSales());
=======
			value.addProperty("v", 500 + i * 100);
>>>>>>> hyun
			value.add("f", null);

			JsonArray cvalArr = new JsonArray();
			cvalArr.add(legend);
			cvalArr.add(value);

			JsonObject cvalObj = new JsonObject();
			cvalObj.add("c", cvalArr);

			arrRows.add(cvalObj);
		}

		data.add("cols", arrCols);
		data.add("rows", arrRows);
		String str = data.toString();
		return str;
	}
}
