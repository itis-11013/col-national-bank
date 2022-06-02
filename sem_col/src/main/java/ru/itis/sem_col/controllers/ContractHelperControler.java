package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.ProductContractDto;

import javax.validation.Valid;

@Controller
public class ContractHelperControler {
    @GetMapping("/newmerch")
    public String getIndex(Model model) {
        //model.addAttribute("text", "111");
        return "marketlist";
    }
        @PostMapping("/pp")
        public ModelAndView registerUserAccount(@ModelAttribute("pruebaDto") @Valid ProductContractDto productcatalog) throws JsonProcessingException {
//        List<ProductDto> products = marketServiceDetails.getCountryProducts("co");
        System.out.println(productcatalog.getMerch_id());
            System.out.println(productcatalog.getMerch_code());
            System.out.println(productcatalog.getCount());


//        return new ModelAndView("excelent", "product", productDto);
        return new ModelAndView("excelent", "product", productcatalog);
    }
}
