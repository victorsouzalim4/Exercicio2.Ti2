package com.ti2cc;
import java.util.Scanner;

public class Principal{
	
	public static Scanner Sc = new Scanner(System.in);
	
	public static Usuario InserirUser() {
		Usuario user = new Usuario();
		
		System.out.println("Digite o codigo do usuario: ");
		user.setCodigo(Sc.nextInt());
		Sc.nextLine();
		System.out.println("Digite o login:");
		user.setLogin(Sc.nextLine());
		System.out.println("Digite a senha:");
		user.setSenha(Sc.nextLine());
		System.out.println("Digite o sexo:");
		String sexo = Sc.nextLine();
		user.setSexo(sexo.charAt(0));
		
		return user;
}
	
	public static Usuario atualizaUser(int codigo) {
		Usuario user = new Usuario();
		
		user.setCodigo(codigo);
		Sc.nextLine();
		System.out.println("Digite o login:");
		user.setLogin(Sc.nextLine());
		System.out.println("Digite a senha:");
		user.setSenha(Sc.nextLine());
		System.out.println("Digite o sexo:");
		String sexo = Sc.nextLine();
		user.setSexo(sexo.charAt(0));
		
		return user;
}
	
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		int opcao;
		
		
		dao.conectar();
		
		System.out.println("==================================================");
		System.out.println("1-Criar usuário\n2-Buscar usuario\n3-Atualizar usuario\n4-Deletar usuario\n5-Buscar todos usuarios");
		System.out.println("==================================================");
		
		
		opcao = Sc.nextInt();
		
		switch(opcao) {
		case 1:
			Usuario usuario = InserirUser();
			boolean status = dao.inserirUsuario(usuario);
			if(status == true) {
				System.out.println("Usuario cadastrado com sucesso!!!");
			}
			else {
				System.out.println("FALHA NO CADASTRO");
			}
			break;
			
		case 2:
			int num;
			System.out.println("Digite o Id do usuario que deseja buscar");
			num = Sc.nextInt();
			Usuario user = dao.getUsuarioId(num);
			System.out.println(user);
			break;
		case 3:
			int num2;
			System.out.println("Digite o Id do usuario que deseja buscar");
			num2 = Sc.nextInt();
			Usuario userAtt = atualizaUser(num2);
			status = dao.atualizarUsuario(userAtt);
			if(status == true) {
				System.out.println("Usuario atualizado com sucesso!!");
			}
			break;
		case 4:
			int num1;
			System.out.println("Digite o Id do usuario que deseja buscar");
			num1 = Sc.nextInt();
			status = dao.excluirUsuario(num1);
			if(status == true) {
				System.out.println("Usuario deletado com sucesso!!");
			}
			break;
		case 5:
			dao.getUsuarios();
			break;
			
		}
			
			
		
		dao.close();
	}
	
	

}
