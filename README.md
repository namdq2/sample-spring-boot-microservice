# Kiến trúc tổng quan
![alt text](https://res.cloudinary.com/deop9ytsv/image/upload/v1545143589/1_Z8HUa8vdvIrF68crSJOPTQ.png)

## 1. Eureka Server
- Eureka Server là một máy chủ quản lý các service, hay còn gọi là service registry. Sau khi một service đăng ký với eureka server, service đó sẽ được đặt tên, ví dụ eureka-server, và chúng ta có thể gọi tới service đó bằng địa chỉ http://eureka-service/.. thay vì phải dùng ip:port.

## 2. Image Service
- Các Eureka client service là một service độc lập trong kiến trúc microservice. Mỗi client service chỉ thực hiện duy nhất một nghiệp vụ nào đó trong hệ thống như thanh toán, tài khoản, thông báo, xác thực, cấu hình,… 
- Image service, là một Eureka client service, như một nguồn để chứa và cung cấp các bức ảnh, mỗi bức ảnh sẽ có id, title và địa chỉ url.

## 3. Gallery Service
- Gallery service, là một Eureka client service, sẽ gọi đến Image service thông qua các endpoint, và từ đó get ra một list ảnh để tạo ra một album.

## 4. Gateway - Zuul
- Một Gateway là một entry point đơn trong hệ thống, được dùng để handle các request bằng cách định tuyến chúng đến các service tương ứng. Nó cũng có thể được dùng để xác thực, giám sát và làm nhiều việc khác.
- Zuul là một proxy, gateway và một lớp trung gian giữa user và các service của bạn. Eureka server đã giải quyết vấn đề đặt tên cho từng service thay vì dùng địa chỉ IP của chúng. Tuy nhiên một service vẫn có thể có nhiều instance và chúng sẽ chạy trên các cổng khác nhau nên nhiệm vụ của Zuul sẽ là:
  + Map giữa một prefix path (/gallery/) và một service (gallery-service). Nó sử dụng Euraka server để định tuyến các service được request.
  + Nó giúp cân bằng tải giữa các instance của một service.
  + Để filter request, thêm xác thực,…
## 5. Auth service
- Auth service, là một dịch xác thực người dùng. Auth service sẽ tạo token cho người dùng và xác thực token của người dùng. 

# Sử dụng
- Chạy lần lượt Eureka Server, các service image, gallery, auth và gateway.
- POST: localhost:8762/auth để lấy token

![alt text](https://res.cloudinary.com/deop9ytsv/image/upload/v1545237441/msa_jwt_img1.jpg)

- GET: localhost:8762/gallery/1 kèm theo token

![alt text](https://res.cloudinary.com/deop9ytsv/image/upload/v1545237474/Screenshot_2.jpg)

Nguồn: tubean
