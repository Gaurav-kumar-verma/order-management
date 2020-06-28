package com.vedantu.repository;

public interface IdSequenceGeneratorCustomRepository {
	
	public boolean insertReleaseLock(String type , boolean toSet);

}
