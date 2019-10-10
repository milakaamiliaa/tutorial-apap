package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.RestoranDB;
import apap.tutorial.gopud.repository.MenuDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @InjectMocks
    RestoranService restoranService = new RestoranServiceImpl();

    @Mock
    MenuDB menuDB;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("Ayam Goreng");
        newMenu.setHarga((BigInteger.valueOf(20000)));
        newMenu.setDeskripsi("Enak");
        newMenu.setDurasiMasak(20);
        menuService.addMenu(newMenu);
        verify(menuDB, times(1)).save(newMenu);
    }

    @Test
    public void whenGetMenuByIdCalledByExistingDataItShouldReturnCorrectData() {
        MenuModel returnedData = new MenuModel();
        returnedData.setNama("Ayam Goreng");
        returnedData.setHarga(BigInteger.valueOf(20000));
        returnedData.setDeskripsi("Enak banget!");
        returnedData.setDurasiMasak(20);
        when(menuService.getMenuById(1L)).thenReturn(Optional.of(returnedData));
        Optional<MenuModel> dataFromServiceCall = menuService.getMenuById(1L);
        verify(menuDB, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());
        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("Ayam Goreng", dataFromOptional.getNama());
        assertEquals(BigInteger.valueOf(20000), dataFromOptional.getHarga());
        assertEquals("Enak banget!", dataFromOptional.getDeskripsi());
        assertEquals(Integer.valueOf(20), dataFromOptional.getDurasiMasak());
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("Ayam Goreng");
        updatedData.setHarga(BigInteger.valueOf(20000));
        updatedData.setDeskripsi("Enak");
        updatedData.setDurasiMasak(Integer.valueOf(20));
        updatedData.setId((long)1);
        menuService.addMenu(updatedData);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);
        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        assertEquals("Ayam Goreng", dataFromServiceCall.getNama());
        assertEquals(BigInteger.valueOf(20000), dataFromServiceCall.getHarga());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
        assertEquals("Enak", dataFromServiceCall.getDeskripsi());
        assertEquals(Integer.valueOf(20), dataFromServiceCall.getDurasiMasak());
    }

    @Test
    public void whenDeleteMenuCalledItShouldDeleteMenuData(){
        MenuModel menuModel = new MenuModel();
        menuModel.setId((long)1);
        when(menuDB.findById(1L)).thenReturn(Optional.of(menuModel));
        menuService.deleteMenu(menuModel);
        verify(menuDB, times(1)).delete(menuModel);
    }
}