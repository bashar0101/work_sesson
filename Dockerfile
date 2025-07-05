# 🌟 استخدم Java 17 أو اللي مشروعك بيشتغل عليه
FROM eclipse-temurin:17-jdk-alpine

# اسم العمل داخل الكونتينر
WORKDIR /app

# انسخ ملف JAR من بيئة البناء
COPY target/*.jar app.jar

# شغّل التطبيق
ENTRYPOINT ["java", "-jar", "app.jar"]