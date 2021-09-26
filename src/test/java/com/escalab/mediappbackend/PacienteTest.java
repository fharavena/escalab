package com.escalab.mediappbackend;


import com.escalab.mediappbackend.model.Usuario;
import com.escalab.mediappbackend.repository.UsuarioRepository;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PacienteTest {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByUserName(username);
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRols().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        UserDetails ud = new User(usuario.getUserName(), usuario.getPassword(), roles);
        return ud;
    }


    public Usuario save(Usuario obj) {
        return usuarioRepository.save(obj);
    }


    public Usuario update(Usuario obj) {
        return usuarioRepository.save(obj);
    }


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


    public Usuario findById(Integer id) {
        Optional<Usuario> op = usuarioRepository.findById(id);
        return op.isPresent() ? op.get() : new Usuario();
    }


    public boolean deleteById(Integer id) {
        usuarioRepository.deleteById(id);
        return true;
    }
}
