package edu.pla.mas.mas_projekt_s17476;

import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import edu.pla.mas.mas_projekt_s17476.gui.controllers.LogInController;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@SpringBootApplication
public class MasProjektS17476Application {
	
	@Autowired
	DataInitializer dataInitializer;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MasProjektS17476Application.class)
				.headless(false).run(args);
		
		//ctx.getBean(DataInitializer.class).initData();
		
		SwingUtilities.invokeLater(() -> {
			ctx.getBean(LogInController.class).showGui();
		});
	}
	
}
