package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testDelete(){
        CityList citylist = new CityList();
        City city = new City("Gazipur", "Dhaka");
        citylist.add(city);

        citylist.delete(city);
        assertFalse(citylist.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException() {
        CityList citylist = new CityList();
        City city = new City("Gazipur", "Dhaka");
        citylist.add(city);

        citylist.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            citylist.delete(city);
        });
    }

    @Test
    public void testCount(){
        CityList citylist = new CityList();
        City city = new City("Gazipur", "Dhaka");
        citylist.add(city);
        assertEquals(1, citylist.count());

        citylist.delete(city);
        assertEquals(0, citylist.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testSort(){
        CityList cityList = new CityList();
        City city = new City("Abstow", "Zeff hardy");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));

        City city1 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
        assertEquals(0, city.compareTo(cityList.getCities(2).get(1)));
    }
}
