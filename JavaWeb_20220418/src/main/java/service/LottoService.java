package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoService {
	public List<Integer> getLottos(Integer count){
		List<Integer> lottos = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			lottos.add(new Random().nextInt(100)+1);
		}
		return lottos;
	}
}
