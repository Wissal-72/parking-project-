## Qst 1 : 

**Comparison with the diagram:** the code has the same seven classes as the diagram, however it hides the tariff 
`switch` in `fee`. it also hides the fact that `FileLogger.log` throws `IOException` and that 
`Main` creates vehicles and  payment methods.

**4 Actors who can ask for a change in `ParkingGarage`:**

1. **Pricing teams**: tariffs (`fee`)
2. **Transactions management team**: payment and refund rules (`checkout`, `cancel`)
3. **Accounting and reporting**: receipt and daily report format
4. **IT**: log destination (`FileLogger`)

## Qst 2:
Review table :

| Principle | Class/method | Lines | Smell |
|---|---|---|---|
| SRP | `ParkingGarage` | 12-19, 27-30, 33-42, 44-51 | Divergent change : the class has 4 unrelated reasons to change  |
| OCP | `ParkingGarage.fee` | 13-18 | Shotgun surgery : `switch` on the vehicle type |
| OCP | `ParkingGarage.cancel` | 35-40 | Shotgun surgery : each payment method with special refund rules adds a branch. |
| LSP | `CashPayment.refund` | 11-13 | Throws `UnsupportedOperationException`. |
| ISP | `PaymentMethod` | 3-7 | Large interface: imposes `refund()` on cash, which cannot refund . |
| DIP | `ParkingGarage` | 9 | `new FileLogger("parking.log")`: policy builds a concrete detail $\rightarrow$ untestable without the file. |
| DIP | `ParkingGarage` | 3, 21-22, 35 | Policy knows concrete details: `IOException` from the file logger leaks into `checkout`. |
 

