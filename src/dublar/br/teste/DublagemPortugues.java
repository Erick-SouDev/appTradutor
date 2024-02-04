package dublar.br.teste;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.Engine;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class DublagemPortugues {

    public static void main(String[] args) throws AudioException, EngineStateError, IllegalArgumentException, InterruptedException {
        // Texto a ser dublado
        String textoOriginal = "oi tudo bem?";

        try {
            // Configuração da síntese de voz
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();

            // Dublagem
            System.out.println("Original: " + textoOriginal);
            System.out.print("Dublado: " );

            synthesizer.speakPlainText(textoOriginal, null);
            synthesizer.waitEngineState(Engine.DEALLOCATED);

        } catch (EngineException e) {
            e.printStackTrace();
        }
    }
}

