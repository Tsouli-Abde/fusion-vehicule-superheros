package com.vehiculemagique;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class VehiculeParameterizedTest {

  @ParameterizedTest(name = "k0={0}, km1={1}, km2={2} => attendu={3}")
  @CsvSource({
      "0, 100, 50, 150",
      "10, 0, 5, 15",
      "0, 999, 0, 999",
      "0, 1000, 0, 1000"
  })
  void cumul_kilometrage(int k0, int km1, int km2, int attendu) {
    Vehicule v = new Vehicule("AA-123-BB");
    v.setKilometrage(k0);
    v.ajouterKilometres(km1);
    v.ajouterKilometres(km2);
    assertEquals(attendu, v.getKilometrage());
  }

  @ParameterizedTest
  @CsvSource({"-1", "-10"})
  void km_negatif_refuse(int kmNeg) {
    Vehicule v = new Vehicule("AA-123-BB");
    assertThrows(IllegalArgumentException.class, () -> v.ajouterKilometres(kmNeg));
  }
}