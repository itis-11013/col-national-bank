package ru.itis.sem_col.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.sem_col.controllers.dto.ProductContractDto;
import ru.itis.sem_col.controllers.dto.ProductDto;
import ru.itis.sem_col.services.MarketServiceDetails;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractHelperController {


    @Autowired
    MarketServiceDetails marketServiceDetails;


    @GetMapping("/newmerch")
    public String getIndex(Model model) {
        return "marketlist";
    }
        @PostMapping("/sendcontract")
        public ModelAndView registerUserAccount(@ModelAttribute("ProductContractDto") @Valid ProductContractDto productcatalog) throws JsonProcessingException {
            List<ProductDto> products = marketServiceDetails.getProductsInMarket();
            if (marketServiceDetails.isProductInMarketSave(productcatalog.getMerch_code(), productcatalog.getCount())){
                return new ModelAndView("excelent", "product", productcatalog);
            }else{
                return new ModelAndView("ProductNotFound", "product", productcatalog);
            }

    }
}
