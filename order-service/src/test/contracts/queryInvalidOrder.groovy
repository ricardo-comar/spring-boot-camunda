import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return an NOT_FOUND code"
    request{
        method GET()
        url("/order/AAA") {
        }
    }
    response {
        status 404 
    }
}