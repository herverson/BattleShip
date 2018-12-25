
import com.br.Exceptions.PreenchidoException;
import com.br.Exceptions.TamanhoNavioException;
import com.br.model.BatalhaMinada;
import com.br.viewcontroller.TelaPrincipal;

public class Teste
{
	public static void main(String[] args)
	{
			
			try
			{
				new TelaPrincipal(new BatalhaMinada());
			} catch (TamanhoNavioException e)
			{
				// TODO Auto-generated catch block
			} catch (PreenchidoException e)
			{
				// TODO Auto-generated catch block
			}
	}
}
