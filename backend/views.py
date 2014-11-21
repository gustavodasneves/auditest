from django.shortcuts import render
from backend.models import Categoria
from rest_framework import viewsets
from backend.serializers import *
# Create your views here.

class ProjetoViewSet(viewsets.ModelViewSet):
    queryset = Projeto.objects.all()
    serializer_class = ProjetoSerializer

class CategoriaViewSet(viewsets.ModelViewSet):
    queryset = Categoria.objects.all()
    serializer_class = CategoriaSerializer

class PerguntaViewSet(viewsets.ModelViewSet):
    queryset = Pergunta.objects.all()
    serializer_class = PerguntaSerializer

class QuestionarioViewSet(viewsets.ModelViewSet):
    queryset = Questionario.objects.all()
    serializer_class = QuestionarioSerializer

class RespostaViewSet(viewsets.ModelViewSet):
    queryset = Resposta.objects.all()
    serializer_class = RespostaSerializer