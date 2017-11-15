import java.util.ArrayList;


public class Investor {

  double value;
  int term;
  int time;
  ArrayList bonds;

/*
Returns payout
getPayout(): double
double result = payments->collect(amount)->sum()
return result

Investor can purchase bonds which are added into a list
purchase(Bond bond): void
add bond to investors array list

Returns all bonds held by an investor
getBondsOwnded():Bond[]
return bond array
*/



double getPayout()  {
  //double result =
  //return result;
}

void purchase(Bond bond)  {
   bonds = new ArrayList();
  bonds.add(bond);
}

Bond[] getBondsOwned()  {
  return bonds;
}

}
