//package br.com.anhanguera.caranavirus.data.generator;
//
//import java.time.LocalDateTime;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//
//import com.vaadin.exampledata.DataType;
//import com.vaadin.exampledata.ExampleDataGenerator;
//import com.vaadin.flow.spring.annotation.SpringComponent;
//
//import br.com.anhanguera.caranavirus.data.entity.User;
//import br.com.anhanguera.caranavirus.data.service.UserRepository;
//import br.com.anhanguera.caranavirus.enuns.TipoSanguinioEnum;
//
//@SpringComponent
//public class DataGenerator {
//
//	@Bean
//	public CommandLineRunner loadData(UserRepository userRepository) {
//		return args -> {
//			Logger logger = LoggerFactory.getLogger(getClass());
//			if (userRepository.count() != 0L) {
//				logger.info("Using existing database");
//				return;
//			}
//			int seed = 123;
//
//			logger.info("Generating demo data");
//
//			logger.info("... generating 100 Sample Person entities...");
//			ExampleDataGenerator<User> samplePersonRepositoryGenerator = new ExampleDataGenerator<>(User.class,
//					LocalDateTime.of(2022, 2, 25, 0, 0, 0));
//			samplePersonRepositoryGenerator.setData(User::setName, DataType.FULL_NAME);
////            samplePersonRepositoryGenerator.setData(User::setEndereco, DataType.ADDRESS);
//			samplePersonRepositoryGenerator.setData(User::setTelefone, DataType.PHONE_NUMBER);
//			samplePersonRepositoryGenerator.setData(User::setCelular, DataType.PHONE_NUMBER);
//			samplePersonRepositoryGenerator.setData(User::setProfissao, DataType.FULL_NAME);
////            samplePersonRepositoryGenerator.setData(User::setTipoSanguinio);
////            samplePersonRepositoryGenerator.setData(User::setImportant, DataType.BOOLEAN_10_90);
//			userRepository.saveAll(samplePersonRepositoryGenerator.create(100, seed));
//
//			logger.info("... generating 2 User entities...");
//			User user = new User();
//			user.setName("John Normal");
////            user.setUsername("user");
////            user.setHashedPassword(passwordEncoder.encode("user"));
////            user.setProfilePictureUrl(
////                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
////            user.setRoles(Collections.singleton(Role.USER));
////            userRepository.save(user);
////            User admin = new User();
////            admin.setName("Emma Powerful");
////            admin.setUsername("admin");
////            admin.setHashedPassword(passwordEncoder.encode("admin"));
////            admin.setProfilePictureUrl(
////                    "https://images.unsplash.com/photo-1607746882042-944635dfe10e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
////            admin.setRoles(Stream.of(Role.USER, Role.ADMIN).collect(Collectors.toSet()));
////            userRepository.save(admin);
//
//			logger.info("Generated demo data");
//		};
//	}
//
//}