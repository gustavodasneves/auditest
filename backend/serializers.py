from backend.models import *
from rest_framework import serializers


class ProjetoSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Projeto
        fields = ('nome','projeto_id',)

class CategoriaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Categoria
        fields = ('nome', 'categoria_id',)

class PerguntaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Pergunta
        fields = ('enunciado', 'categoria', 'pergunta_id',)

class QuestionarioSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Questionario
        fields = ('nome', 'projeto_id', 'questionario_id',)

class RespostaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Resposta
        fields = ('resposta_id', 'pergunta_id', 'valor_resposta', 'data_hora', )

class QuestionarioPerguntaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = QuestionarioPergunta
        fields = ('questionario_id', 'pergunta_id',)




