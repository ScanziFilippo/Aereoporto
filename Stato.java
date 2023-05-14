/**
 * Stati possibili di un aereo
 */
public enum Stato {
    /**
     * l'aereo è a terra
     */
    aTerra, 
    /**
     * l'aereo è in aria e non ha ancora comunicato alla torre di controllo l'intenzione di atterrare
     */
    inAria, 
    /**
     * l'aereo sta atterrando sulla pista sinistra
     */
    atterrandoS, 
    /**
     * l'aereo sta atterrando sulla pista destra
     */
    atterrandoD, 
    /**
     * l'aereo sta decollando dalla pista sinistra
     */
    decollandoS, 
    /**
     * l'aereo sta decollando dalla pista destra
     */
    decollandoD, 
    /**
     * l'aereo è ancora in aria, e ha prenotato un parcheggio
     */
    parcheggioPrenotato, 
        /**
     * l'aereo è ancora in aria, ha prenotato un parcheggio e la pista sinistra
     */
    pistaPrenotataS, 
            /**
     * l'aereo è ancora in aria, ha prenotato un parcheggio e la pista destra
     */
    pistaPrenotataD,
            /**
     * l'aereo è atterrato, e si sta dirigendo al parcheggio
     */
    rullaggioAParcheggio,
                /**
     * l'aereo si sta dirigendo alla pista sinistra
     */
    rullaggioAPistaS, 
    /**
     * l'aereo si sta dirigendo alla pista destra
     */
    rullaggioAPistaD,
    /**
     * l'aereo è decollato
     */
    decollato,
    /**
     * l'aereo ha parcheggiato
     */
    parcheggiato,
    /**
     * l'aereo sta rullando dal parcheggio verso le piste
     */
    inCoda,
    /**
     * l'aereo aspetta che una pista si liberi per potere decollare
     */
    inAttesa
}