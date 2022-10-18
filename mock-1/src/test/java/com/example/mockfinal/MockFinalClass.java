package com.example.mockfinal;

import com.example.model.FinalClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(MockitoExtension.class)
public class MockFinalClass {
    /**
     * 如果mock的对象是final的，需要在resources目录下添加mockito-extensions
     * 然后在mockito-extensions目录下添加文件org.mockito.plugins.MockMaker
     * 文件内容为mock-maker-inline
     *
     * 参考文档：
     * https://yanbin.blog/mockito-mock-final-class-final-method/
     * https://github.com/mockito/mockito/wiki/What's-new-in-Mockito-2#mock-the-unmockable-opt-in-mocking-of-final-classesmethods
     */
    @Mock
    private FinalClass finalclass;

    @Test
    public void test(){
        assertTrue(finalclass!=null);
    }
}
