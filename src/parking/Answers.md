## Qst 1 : 

**Comparison with the diagram:** the code has the same seven classes as the diagram, however it hides the tariff 
`switch` in `fee`. it also hides the fact that `FileLogger.log` throws `IOException` and that 
`Main` creates vehicles and  payment methods.

**4 Actors who can ask for a change in `ParkingGarage`:**

1. **Pricing teams**: tariffs (`fee`)
2. **Transactions management team**: payment and refund rules (`checkout`, `cancel`)
3. **Accounting and reporting**: receipt and daily report format
4. **IT**: log destination (`FileLogger`)

