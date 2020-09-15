import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return even when number input is even"
    request{
        method GET()
        url("/order/a030406b-16b8-4785-9d04-0589fbd088b5") {
        }
    }
    response {
        body(file("order-valid.json"))
        status 200 
    }
}