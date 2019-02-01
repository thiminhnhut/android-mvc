Model View Controller trong Android
###################################

* **Thực hiện:** Thi Minh Nhựt - **Email:** thiminhnhut@gmail.com

* **Thời gian:** Ngày 01 tháng 02 năm 2019

.. sectnum::

.. contents:: Nội dung

Nội dung
********

Giới thiệu
==========

* Model View Controller - MVC là mẫu thiết kế với mục tiêu phân tách phần giao diện và phần code với nhau để dễ quản lý, phát triển và bảo trì.

* MVC chia phần mềm thành 3 thành phần:

  * Model: lớp chưa thông tin đối tượng, tương tác với Database. Chịu trách nhiệm trong mô hình hóa đối tượng.

  * View: giao diện của hệ thống tương tác trực tiếp với người dùng.

  * Controller: Code điều khiển tương tác giữa Model và View hay code business. Nhận yêu cầu từ người dùng, sử dụng Model và View để xử lý và trả về kết quả cho người dùng.

  .. image:: images/mvc-pattern.png

Ví dụ
=====

* Examples: `Login to the ATM <https://github.com/thiminhnhut/android-mvc/tree/master/LoginATM>`_