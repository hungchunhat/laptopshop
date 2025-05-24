package com.example.laptopshop.seeder;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.Role;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final RoleService roleService;
    private final ProductService productService;

    DataSeeder(RoleService roleService, ProductService productService) {
        this.roleService = roleService;
        this.productService = productService;
    }
    @Override
    public void run(String... args) throws Exception {
        if(roleService.getRoleCount() == 0){
            Role role = new Role();
            role.setName("ADMIN");
            role.setDescription("Admin thì full quyền");
            System.out.println("Tạo thành công role: " + roleService.handleSaveRole(role));
            Role role2 = new Role();
            role2.setName("USER");
            role2.setDescription("User bình thường");
            System.out.println("Tạo thành công role: " + roleService.handleSaveRole(role2));
        }
        if(productService.getProductCount() == 0){
            productService.handleSaveProduct(new Product(1,
                    "Laptop Asus TUF Gaming",
                    17490000,
                    "1711078092373-asus-01.png",
                    "ASUS TUF Gaming F15 FX506HF HN017W là chiếc laptop gaming giá rẻ nhưng vô cùng mạnh mẽ. Không chỉ bộ vi xử lý Intel thế hệ thứ 11, card đồ họa RTX 20 series mà điểm mạnh còn đến từ việc trang bị sẵn 16GB RAM, cho bạn hiệu năng xuất sắc mà không cần nâng cấp máy.",
                    "Intel, Core i5, 11400H",
                    100,
                    0,
                    "ASUS",
                    "GAMING"));

            productService.handleSaveProduct(new Product(2,
                    "Laptop Dell Inspiron 15 ",
                    15490000,
                    "1711078452562-dell-01.png",
                    "Khám phá sức mạnh tối ưu từ Dell Inspiron 15 N3520, chiếc laptop có cấu hình cực mạnh với bộ vi xử lý Intel Core i5 1235U thế hệ mới và dung lượng RAM lên tới 16GB. Bạn có thể thoải mái xử lý nhiều tác vụ, nâng cao năng suất trong công việc mà không gặp bất kỳ trở ngại nào.",
                    "i5 1235U/16GB/512GB/15.6\"FHD",
                    200,
                    0,
                    "DELL",
                    "SINHVIEN-VANPHONG"));

            productService.handleSaveProduct(new Product(3,
                    "Lenovo IdeaPad Gaming 3",
                    19500000,
                    "1711079073759-lenovo-01.png",
                    "Mới đây, Lenovo đã tung ra thị trường một sản phẩm gaming thế hệ mới với hiệu năng mạnh mẽ, thiết kế tối giản, lịch lãm phù hợp cho những game thủ thích sự đơn giản. Tản nhiệt mát mẻ với hệ thống quạt kép kiểm soát được nhiệt độ máy luôn mát mẻ khi chơi game.",
                    "i5-10300H, RAM 8G",
                    150,
                    0,
                    "LENOVO",
                    "GAMING"));

            productService.handleSaveProduct(new Product(4,
                    "Asus K501UX",
                    11900000,
                    "1711079496409-asus-02.png",
                    "Tận hưởng cảm giác mát lạnh sành điệu với thiết kế kim loại. Được thiết kế để đáp ứng những nhu cầu điện toán hàng ngày của bạn, dòng máy tính xách tay ASUS K Series sở hữu thiết kế tối giản, gọn nhẹ và cực mỏng với một lớp vỏ họa tiết vân kim loại phong cách. Hiệu năng của máy rất mạnh mẽ nhờ trang bị bộ vi xử lý Intel® Core™ i7 processor và đồ họa mới nhất.",
                    "VGA NVIDIA GTX 950M- 4G",
                    99,
                    0,
                    "ASUS",
                    "THIET-KE-DO-HOA"));

            productService.handleSaveProduct(new Product(5,
                    "MacBook Air 13",
                    17690000,
                    "1711079954090-apple-01.png",
                    "Chiếc MacBook Air có hiệu năng đột phá nhất từ trước đến nay đã xuất hiện. Bộ vi xử lý Apple M1 hoàn toàn mới đưa sức mạnh của MacBook Air M1 13 inch 2020 vượt xa khỏi mong đợi người dùng, có thể chạy được những tác vụ nặng và thời lượng pin đáng kinh ngạc.",
                    "Apple M1 GPU 7 nhân",
                    99,
                    0,
                    "APPLE",
                    "GAMING"));

            productService.handleSaveProduct(new Product(6,
                    "Laptop LG Gram Style",
                    31490000,
                    "1711080386941-lg-01.png",
                    "14.0 Chính: inch, 2880 x 1800 Pixels, OLED, 90 Hz, OLED",
                    "Intel Iris Plus Graphics",
                    99,
                    0,
                    "LG",
                    "DOANH-NHAN"));

            productService.handleSaveProduct(new Product(7,
                    "MacBook Air 13 ",
                    24990000,
                    "1711080787179-apple-02.png",
                    "Không chỉ khơi gợi cảm hứng qua việc cách tân thiết kế, MacBook Air M2 2022 còn chứa đựng nguồn sức mạnh lớn lao với chip M2 siêu mạnh, thời lượng pin chạm ngưỡng 18 giờ, màn hình Liquid Retina tuyệt đẹp và hệ thống camera kết hợp cùng âm thanh tân tiến.",
                    "Apple M2 GPU 8 nhân",
                    99,
                    0,
                    "APPLE",
                    "MONG-NHE"));

            productService.handleSaveProduct(new Product(8,
                    "Laptop Acer Nitro ",
                    23490000,
                    "1711080948771-acer-01.png",
                    "Là chiếc laptop gaming thế hệ mới nhất thuộc dòng Nitro 5 luôn chiếm được rất nhiều cảm tình của game thủ trước đây, Acer Nitro Gaming AN515-58-769J nay còn ấn tượng hơn nữa với bộ vi xử lý Intel Core i7 12700H cực khủng và card đồ họa RTX 3050, sẵn sàng cùng bạn chinh phục những đỉnh cao.",
                    "AN515-58-769J i7 12700H",
                    99,
                    0,
                    "ACER",
                    "SINHVIEN-VANPHONG"));

            productService.handleSaveProduct(new Product(9,
                    "Laptop Acer Nitro V",
                    26999000,
                    "1711081080930-asus-03.png",
                    "15.6 inch, FHD (1920 x 1080), IPS, 144 Hz, 250 nits, Acer ComfyView LED-backlit",
                    "NVIDIA GeForce RTX 4050",
                    99,
                    0,
                    "ASUS",
                    "MONG-NHE"));

            productService.handleSaveProduct(new Product(10,
                    "Laptop Dell Latitude 3420",
                    21399000,
                    "1711081278418-dell-02.png",
                    "Dell Inspiron N3520 là chiếc laptop lý tưởng cho công việc hàng ngày. Bộ vi xử lý Intel Core i5 thế hệ thứ 12 hiệu suất cao, màn hình lớn 15,6 inch Full HD 120Hz mượt mà, thiết kế bền bỉ sẽ giúp bạn giải quyết công việc nhanh chóng mọi lúc mọi nơi.",
                    "Intel Iris Xe Graphics",
                    99,
                    0,
                    "DELL",
                    "MONG-NHE"));
            System.out.println("Đã seed dữ liệu Products!");
        }
    }
}
