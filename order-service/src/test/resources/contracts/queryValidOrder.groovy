import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "should return even when number input is even"
    request{
        method GET()
        url("/order/449d56c8-c453-4ef1-8d63-29ad241c4b61") {
        }
    }
    response {
        status 200
    }
}