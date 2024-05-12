<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Management System</title>
    <link rel="stylesheet" href="./css/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Reddit+Sans:ital,wght@0,200..900;1,200..900&display=swap"
            rel="stylesheet" />

</head>
<body>

<%@ include file="header.jsp" %>

<!-- Hero Section -->
<div class="text-center">
    <h1 class="heading text-center">
        Your All-in-one <span class="highlight">Event Planning</span> Platform
    </h1>

    <p class="description">
        Our event planning system is your ultimate solution for organizing seamless and memorable events. Whether it's a wedding, corporate gathering, or social event, we provide the tools and support to make your planning process smooth and stress-free.
    </p>

    <a href="Register.jsp" class="btn btn-primary btn-lg btn-custom">Create Account</a>
</div>

<!-- Event Apply CTA Section -->
<div class="cta-section">
    <div class="cta-bg">
        <div class="cta-content">
            <h1 class="cta-heading">Request Your Event Plan</h1>
            <a href="requestEvent.jsp" class="btn btn-primary btn-lg btn-custom">Request Event</a>
        </div>
    </div>
</div>


<!-- Process Section -->
<section id="process" class="process-section">
    <div class="section-heading">
        <h1 class="heading">This is Your Event Planning Process</h1>

    </div>
    <div class="process-grid">
        <div class="process-item">
            <h1 class="number">01</h1>
            <h3 class="process-title">Request Your Demo Plan</h3>
            <p class="process-description">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ipsam
                necessitatibus quidem voluptatem consequuntur dignissimos
                consectetur placeat corporis tempore veniam, illo nemo, cumque sit
                itaque natus saepe, nisi fuga eum dolore.
            </p>
        </div>
        <div class="process-item">
            <h1 class="number">02</h1>
            <h3 class="process-title">Assign Our Event Planner</h3>
            <p class="process-description">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ipsam
                necessitatibus quidem voluptatem consequuntur dignissimos
                consectetur placeat corporis tempore veniam, illo nemo, cumque sit
                itaque natus saepe, nisi fuga eum dolore.
            </p>
        </div>
        <div class="process-item">
            <h1 class="number">03</h1>
            <h3 class="process-title">Execute your Plan & Enjoy</h3>
            <p class="process-description">
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Ipsam
                necessitatibus quidem voluptatem consequuntur dignissimos
                consectetur placeat corporis tempore veniam, illo nemo, cumque sit
                itaque natus saepe, nisi fuga eum dolore.
            </p>
        </div>
    </div>
</section>


</body>
</html>