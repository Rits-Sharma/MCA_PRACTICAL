// 1. Implement a class called WebsiteVisitor that tracks the number of visitors to a website. Each time an object of WebsiteVisitor is created, increment a static counter variable and display the total number of visitors.

class WebsiteVisitor {
    static int noOfVisitor = 0;
    public WebsiteVisitor() {
        noOfVisitor++;
    }
    void display() {
        System.out.println("No of Visitors: " + noOfVisitor);
    }
}

public class Question1 {
    
    public static void main(String[] args) {
        WebsiteVisitor web1 = new WebsiteVisitor();
        WebsiteVisitor web2 = new WebsiteVisitor();
        WebsiteVisitor web3 = new WebsiteVisitor();
        web3.display();
    }
}
