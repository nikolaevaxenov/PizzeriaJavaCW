package pizzeria.main.Services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.main.Classes.Address;
import pizzeria.main.Classes.Card;
import pizzeria.main.Classes.Users;
import pizzeria.main.Config.PasswordEncoding;
import pizzeria.main.Dto.User.AddrInfoDto;
import pizzeria.main.Dto.User.CardInfoDto;
import pizzeria.main.Dto.User.UsersSignInDto;
import pizzeria.main.Dto.User.UsersSignUpDto;
import pizzeria.main.Interfaces.AddressRepository;
import pizzeria.main.Interfaces.CardRepository;
import pizzeria.main.Interfaces.UsersRepository;
import pizzeria.main.Session.UsersInfo;

import java.util.List;
import java.util.Optional;
//сервис класса пользователь
@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final CardRepository cardRepository;
    private final AddressRepository addressRepository;

    PasswordEncoding passwordEncoding = new PasswordEncoding();

    @Transactional(readOnly = true)
    public Users findUsers(UsersInfo usersInfo){
        return usersRepository.findById(usersInfo.getUserId()).get();
    }

    @Transactional(readOnly = true)
    public boolean findUsersById(String id) {
        return usersRepository.findById(id).isPresent();

    }

    @Transactional
    public String signup(UsersSignUpDto usersSignUpDto){
        usersSignUpDto.setPw(passwordEncoding.encode(usersSignUpDto.getPw()));
        return usersRepository.save(usersSignUpDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public boolean signin(UsersSignInDto usersSignInDto){
        String dbResultPw = usersRepository.getOne(usersSignInDto.getId()).getPw();
        String bodyResultPw = usersSignInDto.getPw();
        return passwordEncoding.matches(bodyResultPw, dbResultPw);
    }

    @Transactional(readOnly = true)
    public List<Card> findAllCard(UsersInfo usersInfo){
        return cardRepository.findAllByUsers_Id(usersInfo.getUserId());
    }

    @Transactional(readOnly = true)
    public Card findCardByCardId(String cardId){
        return cardRepository.findById(cardId).get();
    }

    @Transactional
    public String addCard(CardInfoDto cardInfoDto){
        return cardRepository.save(cardInfoDto.toEntity()).getId();
    }

    @Transactional
    public void deleteCard(String cardId) {
        cardRepository.delete(cardRepository.findById(cardId).get());
    }

    @Transactional(readOnly = true)
    public List<Address> findAllAddr(UsersInfo usersInfo){
        return addressRepository.findAllByUsers_Id(usersInfo.getUserId());
    }

    @Transactional(readOnly = true)
    public Address findAddrByUid(Long addrUid){
        return addressRepository.findById(addrUid).get();
    }

    @Transactional
    public Long addAddr(AddrInfoDto addrInfoDto){
        return addressRepository.save(addrInfoDto.toEntity()).getUid();
    }

    @Transactional
    public void deleteAddr(Long addrUid){
        addressRepository.delete(addressRepository.findById(addrUid).get());
    }

}
