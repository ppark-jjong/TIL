package classFile;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController implements ApplicationContextAware {
	private ApplicationContext context = null;
	private ProductDao productDao = null;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.productDao = new ProductDao();
	}

	@GetMapping("/shopping")
	String itemList(@RequestParam("maker") String maker, Model model) {
		List<Item> items = productDao.selectAll(maker);
		model.addAttribute("items", items);
		return "itemView";
	}
	
	@PostMapping("/shopping")
	String submit(@ModelAttribute("orderCommand") List<Order> orders, Model model) {
		Order order = orders.get(0);
		productDao.insert(order);
		model.addAttribute("order", order);
		return "orderSubmitted";
	}
}