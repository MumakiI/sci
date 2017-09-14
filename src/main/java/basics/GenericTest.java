package basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Anton_Markov on 8/11/2017.
 */
public class GenericTest<T>
{
	public void set(T t){}
	public T get(){return null;}
}

interface  A{}
interface B extends A{}


class test {
	void test() {

		GenericTest<B> b = null;
		GenericTest<? extends A> ea = b;

		A a = ea.get();

		GenericTest<? super List> w = new GenericTest<List>();

		w.set(new ArrayList());
		Object l = w.get();
	}

}